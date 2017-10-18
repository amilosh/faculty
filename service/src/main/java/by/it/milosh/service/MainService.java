package by.it.milosh.service;

public interface MainService {

    /**
     * Determine name of personal page depending on the role: admin, student or teacher.
     * @param userRole - role of user
     * @return name of personal page depending on the role: admin, student or teacher
     */
    String determinePersonalPageByUserRole(String userRole);

}
