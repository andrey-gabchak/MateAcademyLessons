package academy.mate.lesson6Mockito;

import java.util.Objects;

public class Main {
    private UserDao userDao = new UserDao();
    private EmailService emailService = new EmailService();

    public User addUser(User user) {
        return userDao.addUser(user);
    }

    public User findByEmail(String email) {
        User user = userDao.findByEmail(email);
        user = modifyUser(user);
        return user;
    }

    User modifyUser(User user) {
        user.setAge(11);
        user.setEmail("newEmail");
        user.setUserName("newUserName");
        return user;
    }

    public void sendEmail(User user) {
        emailService.send(user.getEmail());
    }

    public static class User {
        private String userName;
        private String email;
        private Integer age;

        public User(String userName, String email, Integer age) {
            this.userName = userName;
            this.email = email;
            this.age = age;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(userName, user.userName) &&
                    Objects.equals(email, user.email) &&
                    Objects.equals(age, user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userName, email, age);
        }
    }

}
