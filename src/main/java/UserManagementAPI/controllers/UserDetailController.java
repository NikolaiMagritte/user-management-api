package UserManagementAPI.controllers;

import UserManagementAPI.model.UserDetail;
import UserManagementAPI.services.UserDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users/{userId}/details")
@Api(tags = "User Detail Management")
public class UserDetailController {
    private final UserDetailService userDetailService;

    @ApiOperation("Create a new user detail for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User detail created successfully")
    })
    @PostMapping
    public ResponseEntity<UserDetail> createUserDetail(@PathVariable Long userId, @RequestBody UserDetail userDetail) {
        UserDetail createdUserDetail = userDetailService.createUserDetail(userId, userDetail);
        return ResponseEntity.ok(createdUserDetail);
    }

    @ApiOperation("Update the user detail for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User detail updated successfully"),
            @ApiResponse(code = 404, message = "User detail not found")
    })
    @PutMapping
    public ResponseEntity<UserDetail> updateUserDetail(@PathVariable Long userId, @RequestBody UserDetail userDetail) {
        UserDetail updatedUserDetail = userDetailService.updateUserDetail(userId, userDetail);
        return ResponseEntity.ok(updatedUserDetail);
    }

    @ApiOperation("Delete the user detail for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User detail deleted successfully"),
            @ApiResponse(code = 404, message = "User detail not found")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteUserDetail(@PathVariable Long userId) {
        userDetailService.deleteUserDetail(userId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("Get the user detail for the specified user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User detail retrieved successfully"),
            @ApiResponse(code = 404, message = "User detail not found")
    })
    @GetMapping
    public ResponseEntity<UserDetail> getUserDetailByUserId(@PathVariable Long userId) {
        UserDetail userDetail = userDetailService.getUserDetailByUserId(userId);
        return ResponseEntity.ok(userDetail);
    }
}

