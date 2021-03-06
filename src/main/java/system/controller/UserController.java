package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.requesthandle.RequestHandler;
import system.service.UserService;
import system.vo.LoginVO;
import system.vo.RegistrationUserVO;
import system.vo.ResponseVO;

import java.util.Date;

@RestController
@RequestMapping(path="/api/user")
public class UserController {


	@Autowired
	UserService userService;

	@RequestMapping(value = "/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> registrationUser(@RequestBody RegistrationUserVO registrationUserVO) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return userService.userRegistration(registrationUserVO);
			}
		};
		return handler.getResult();
	}

	@RequestMapping(value = "/delete",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> deleteUser(@RequestParam (value = "secureId", required = true) String secureId) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return userService.deleteUser(secureId);
			}
		};
		return handler.getResult();
	}

	@RequestMapping(value = "/update",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> updateUser(@RequestParam (value = "secureId", required = true) String secureId,
												 @RequestBody RegistrationUserVO registrationUserVO) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return userService.updateUser(secureId , registrationUserVO);
			}
		};
		return handler.getResult();
	}

	@RequestMapping(value = "/list",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> getAll(){
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return userService.listUser();
			}
		};
		return handler.getResult();
	}

	@RequestMapping(value = "/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> login(@RequestBody LoginVO loginVO) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return userService.userLogin(loginVO);
			}
		};
		return handler.getResult();
	}

	@RequestMapping(value = "/logout",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> logout(@RequestParam(value = "keyAccess", required = true) String keyAccess) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return userService.userLogout(keyAccess);
			}
		};
		return handler.getResult();
	}
	
	@GetMapping(path="/ping")
	public @ResponseBody
	Date getAllUsers() {
		Date ping = new Date();
		return ping;
	}
}
