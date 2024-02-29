package bytebrewers.bitpod.controller;

import java.util.List;

import bytebrewers.bitpod.utils.constant.ApiUrl;
import bytebrewers.bitpod.utils.constant.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bytebrewers.bitpod.entity.User;
import bytebrewers.bitpod.service.UserService;
import bytebrewers.bitpod.utils.dto.Res;
import bytebrewers.bitpod.utils.dto.request.user.TopUpDTO;
import bytebrewers.bitpod.utils.dto.request.user.UserDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiUrl.BASE_URL + ApiUrl.BASE_USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'MEMBER')")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO){
        UserDTO data = userService.updateUser(userDTO);
        return Res.renderJson(data, Messages.USER_UPDATED, HttpStatus.OK);
    }    

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public List<User> index(){
        return userService.getAllUser();
    }
    
    @PostMapping("/topup")
    public ResponseEntity<?> topup(@RequestBody TopUpDTO topUpDTO){
        TopUpDTO topUp = userService.topUp(topUpDTO);
        return Res.renderJson(topUp, "topup success", HttpStatus.OK);
    }

    
}