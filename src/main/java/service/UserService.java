package service;

import model.Permission;
import model.Role;
import model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Person;


public class UserService {

    public static List<User> findUsersWhoHaveMoreThanOneAddress(List<User> users) {
        return users.stream().filter(user -> user.getPersonDetails().getAddresses().size() > 1).toList();
    }

    public static User findOldestPerson(List<User> users) {
        return users.stream().filter(user -> user.getPersonDetails().getAge() == users.stream().mapToInt(user1 -> user1.getPersonDetails().getAge()).max().getAsInt()).findFirst().get();
    }

    public static User findUserWithLongestUsername(List<User> users) {
        return users.stream().filter(user -> user.getName().length() == users.stream().mapToInt(user1 -> user1.getName().length()).max().getAsInt()).findFirst().get();
    }

    public static String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(List<User> users) {
        return users.stream().filter(user -> user.getPersonDetails().getAge() > 18).map(user -> user.getPersonDetails().getName() + " " + user.getPersonDetails().getSurname()).collect(Collectors.joining(", "));
    }

    public static List<String> getSortedPermissionsOfUsersWithNameStartingWithA(List<User> users) {
        return users.stream().filter(user -> user.getName().startsWith("A")).flatMap(user -> user.getPersonDetails().getRole().getPermissions().stream()).map(Permission::getName).sorted().toList();
    }

    public static void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(List<User> users) {
        users.stream().filter(user -> user.getPersonDetails().getSurname().startsWith("S")).forEach(user -> user.getPersonDetails().getRole().getPermissions().forEach(permission -> System.out.println(permission.getName().toUpperCase())));
    }

    public static Map<Role, List<User>> groupUsersByRole(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(user -> user.getPersonDetails().getRole()));
    }

    public static Map<Boolean, List<User>> partitionUserByUnderAndOver18(List<User> users) {
        return users.stream().collect(Collectors.partitioningBy(user -> user.getPersonDetails().getAge() > 18));
    }
}
