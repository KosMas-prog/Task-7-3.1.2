package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@PreAuthorize("hasRole('ADMIN')")
public class RoleRestController {

    private final RoleService roleService;

    @Autowired
    public RoleRestController (RoleService roleService){
        this.roleService = roleService;
    }

    //Получить все роли
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    //получить роль по ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    //Создать новую роль
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role createdRole = roleService.saveRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    //Обновить существующую роль
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role){
        role.setId(id);
        Role updatedRole = roleService.updateRole(id, role);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    //Удаление оли
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
