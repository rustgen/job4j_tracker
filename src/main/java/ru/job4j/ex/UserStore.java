package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(login)) {
                user = users[i];
            } else {
                throw new UserNotFoundException("No user found");
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() || user.getUsername().length() > 3) {
            return true;
        } else {
            throw new UserInvalidException("User is not valid");
        }
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
