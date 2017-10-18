package by.it.milosh.serviceImpl;

import by.it.milosh.Enums.RoleEnum;
import by.it.milosh.service.MainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    @Override
    public String determinePersonalPageByUserRole(String roleName) {
        String forwardPage = "";
        if (roleName.equals(RoleEnum.STUDENT.getType())) {
            forwardPage = "redirect:/personalStudent";
        } else if (roleName.equals(RoleEnum.TEACHER.getType())) {
            forwardPage = "redirect:/personalTeacher";
        } else if (roleName.equals(RoleEnum.ADMIN.getType())) {
            forwardPage = "admin/admin";
        }
        return forwardPage;
    }
}
