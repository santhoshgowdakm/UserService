package com.example.userservice.controller;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/v1/api/userservice")
public class UserController {
    @Autowired
    private UserService userService;
    @Operation(summary = "It will add the registered user")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "we will add the registered data", content={
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "404", description = "page not found", content={
                    @Content()
            }),
            @ApiResponse(responseCode = "500", description = "internal server error", content={
                    @Content()
            })
    })
    @PostMapping("/add")
    public String addnewUser(@RequestBody User user){
        return this.userService.addUser(user);

    }
    @Operation(summary = "It will delete the user by id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "User data is deleted", content={
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "404", description = "page not found", content={
                    @Content()
            }),
            @ApiResponse(responseCode = "500", description = "internal server error", content={
                    @Content()
            })
    })
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return this.userService.userDelete(id);
    }
    @Operation(summary = "It will update the user by id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = " user data  is updated", content={
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "404", description = "page not found", content={
                    @Content()
            }),
            @ApiResponse(responseCode = "500", description = "internal server error", content={
                    @Content()
            })
    })
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        return this.userService.userUpdate(id,user);
    }

}
