package UserManagementAPI.controllers;

import UserManagementAPI.services.UserPhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/users/{userId}/photo")
@Api(tags = "User Photo Management")
@RequiredArgsConstructor
public class UserPhotoController {
    private final UserPhotoService userPhotoService;

    @ApiOperation("Get the user photo for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User photo retrieved successfully"),
            @ApiResponse(code = 404, message = "User photo not found")
    })
    @GetMapping
    public ResponseEntity<byte[]> getUserPhoto(@PathVariable Long userId) {
        byte[] photo = userPhotoService.getUserPhoto(userId);
        return ResponseEntity.ok(photo);
    }

    @ApiOperation("Update the user photo for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User photo updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 404, message = "User photo not found")
    })
    @PutMapping
    public ResponseEntity<Void> updateUserPhoto(@PathVariable Long userId, @RequestParam("photo") MultipartFile file) throws IOException {
        byte[] photo = file.getBytes();
        userPhotoService.updateUserPhoto(userId, photo);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("Delete the user photo for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User photo deleted successfully"),
            @ApiResponse(code = 404, message = "User photo not found")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteUserPhoto(@PathVariable Long userId) {
        userPhotoService.deleteUserPhoto(userId);
        return ResponseEntity.ok().build();
    }
}

