package cn.edwardLearn;

/**
 * author:  zhangkun .
 * date:    on 2018/5/29.
 */
public class Stu {

    private String name;
    private int age;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String gender(boolean isMain) {
        return isMain ? "i am main" : "i am not main";
    }

    public void printNumbers(int[] numBers) {
        for (int num : numBers) {
            System.out.println(num);
        }
    }

    public class Address {

        private String address;

        private Street street;


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Street getStreet() {
            return street;
        }

        public void setStreet(Street street) {
            this.street = street;
        }

        public class Street {

            private String name;


            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
