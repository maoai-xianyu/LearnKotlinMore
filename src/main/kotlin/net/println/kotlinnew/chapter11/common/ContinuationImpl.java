package net.println.kotlinnew.chapter11.common;

import com.sun.source.tree.BreakTree;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import net.println.kotlinnew.chapter11.utils.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangkun
 * @time 2020/12/13 9:11 下午
 */
public class ContinuationImpl implements Continuation<Object> {

    private int label = 0;
    private final Continuation<Unit> completion;

    public ContinuationImpl(Continuation<Unit> completion) {
        this.completion = completion;
    }

    @NotNull
    @Override
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override
    public void resumeWith(@NotNull Object o) {
        try {
            Object result = o;
            switch (label){
                case 0:
                    Logger.debug(1);
                    result = ConsoleMainKt.returnSuspend(this);
                    label++;
                    // 检查返回值：一种是挂起的标记，一种的是真正的返回值
                    // 挂起后，恢复的时候会再调用 resumeWith,将结果传入进来
                    if (isSuspended(result)){
                        Logger.debug("returnSuspend 是挂起点");
                        return;
                    }
                case 1:
                    Logger.debug(result);
                    Logger.debug(2);
                    result = DelayKt.delay(1000,this);
                    label++;
                    if (isSuspended(result)){
                        Logger.debug("delay 是挂起点");
                        return;
                    }
                case 2:
                    Logger.debug(3);
                    result = ConsoleMainKt.returnImmediately(this);
                    label++;
                    if (isSuspended(result)){
                        Logger.debug("returnImmediately 是挂起点");
                        return;
                    }
                case 3:
                    Logger.debug(result);
                    Logger.debug(4);
            }
            completion.resumeWith(Unit.INSTANCE);
        } catch (Exception e) {
            completion.resumeWith(e);
        }

    }

    // 判读是不是挂起点
    private boolean isSuspended(Object o) {
        return o == IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
