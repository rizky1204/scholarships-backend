package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.requesthandle.RequestHandler;
import system.service.ScholarshipsService;
import system.vo.ScholarshipsCreateVO;
import system.vo.ScholarshipsUpdateVO;
import system.vo.ResponseVO;

import java.util.Date;

@RestController
@RequestMapping(path="/api/scholarships")
public class ScholarshipsController {


	@Autowired
	ScholarshipsService scholarshipsService;

	@RequestMapping(value = "/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseVO> registrationUser(@RequestBody ScholarshipsCreateVO scholarshipsCreateVO) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return scholarshipsService.createScholarships(scholarshipsCreateVO);
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
				return scholarshipsService.deleteCountry(secureId);
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
												 @RequestBody ScholarshipsUpdateVO scholarshipsUpdateVO) {
		RequestHandler handler = new RequestHandler() {
			@Override
			public Object processRequest() {
				return scholarshipsService.updateCountry(scholarshipsUpdateVO, secureId);
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
				return scholarshipsService.listCountry();
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
