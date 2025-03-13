package ru.itmentor.spring.boot_security.demo.service;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    //Получить все роли
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    //Получить роль по ID
    public Role getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    //Сохранить роль
    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    //Обновить роль
    public Role updateRole(Long id, Role role){
        role.setId(id);
        return roleRepository.save(role);
    }

    //Удалить роль
    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
}
