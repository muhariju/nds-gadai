package id.co.nds.gadai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai.models.ResponseModel;
import id.co.nds.gadai.models.UserModel;
import id.co.nds.gadai.services.UserService;
import id.co.nds.gadai.entities.UserEntity;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/doGetAllUsers")
    public ResponseEntity<ResponseModel> doGetAllUsers() {
        // request
        List<UserEntity> users = userService.doGetAllUsers();
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(users);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doSearchUser")
    public ResponseEntity<ResponseModel> doSearchUserController(@RequestParam(required = false) String id,
    String namaUser, String Keterangan, String recStatus, String nomorHp) {
        // request
        UserModel user = new UserModel();
        user.setId(id);
        user.setNamaUser(namaUser);
        user.setKeterangan(Keterangan);
        user.setRecStatus(recStatus);
        user.setNomorHp(nomorHp);
        List<UserEntity> users = userService.doSearchUser(user);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(users);
        return ResponseEntity.ok(response);
        
    }

    @GetMapping(value = "/doGetDetailUser/{id}")
    public ResponseEntity<ResponseModel> doGetDetailUserController(@PathVariable String id) {
        // request
        UserEntity user = userService.findById(id);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(user);
        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/doInsert")
    public ResponseEntity<ResponseModel> doInsertUserController(
            @Valid @RequestBody UserModel userModel) {
        UserEntity user = userService.doInsert(userModel);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("New user is successfully added");
        response.setData(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/doUpdate")
    public ResponseEntity<ResponseModel> doUpdateUserController(
            @RequestBody UserModel userModel) {
        // request
        UserEntity user = userService.doUpdate(userModel);

        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("User is successfully updated");
        response.setData(user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/doDelete")
    public ResponseEntity<ResponseModel> doDeleteUserController(
            @RequestBody UserModel userModel) {
        // request
        UserEntity user = userService.doDelete(userModel);

        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("User is successfully deleted");
        response.setData(user);
        return ResponseEntity.ok(response);
    }
}
