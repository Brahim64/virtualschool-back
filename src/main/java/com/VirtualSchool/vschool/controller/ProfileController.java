package com.VirtualSchool.vschool.controller;

import com.VirtualSchool.vschool.model.dto.UserDTO;
import com.VirtualSchool.vschool.model.request.ProfileRequest;
import com.VirtualSchool.vschool.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> getProfile(@RequestBody ProfileRequest profileRequest) {
        // get email from token = qhmed...
        // get profile owner = samir
        // compare
        var profile=profileService.getProfile(profileRequest.getId());
        return ResponseEntity.ok(profile);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id,@RequestBody UserDTO userDTO) {
        try {
            Long newId=Long.valueOf(id);
            profileService.updateProfile(newId, userDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
