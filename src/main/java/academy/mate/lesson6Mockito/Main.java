package academy.mate.lesson6Mockito;

public class Main {
    private UserDao userDao = new UserDao();
    private EmailService emailService = new EmailService();

    public User addUser(User user) {
        return userDao.addUser(user);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
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
    }

}
