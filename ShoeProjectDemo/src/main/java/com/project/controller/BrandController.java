package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.ObjectReturn;
import com.project.model.Brand;
import com.project.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	private BrandService service;

	@GetMapping(value = "/brands")
	public ObjectReturn<Brand> getAll() {
		return service.getAll();
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/brand", consumes = "application/json")
	public Brand createBrand(@RequestBody Brand brand) {
		return service.createBrand(brand);
	}

//	@PostMapping("")
//	public ResponseEntity<?> createPost(@RequestBody @Valid Post post, BindingResult result) {
//		if (result.hasErrors()) {
//			StringBuilder devErrorMsg = new StringBuilder();
//			List<ObjectError> allErrors = result.getAllErrors();
//			for (ObjectError objectError : allErrors) {
//				devErrorMsg.append(objectError.getDefaultMessage() + "\n");
//			}
//			ErrorDetails errorDetails = new ErrorDetails();
//			errorDetails.setErrorCode("ERR-1400");// Business specific error codes
//			errorDetails.setErrorMessage("Invalid Post data received");
//			errorDetails.setDevErrorMessage(devErrorMsg.toString());
//
//			return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//		}
//		Post savedPost = postRepository.save(post);
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		return new ResponseEntity<>(savedPost, responseHeaders, HttpStatus.CREATED);
//	}
//
//	
//
//	@PutMapping("/{id}")
//	public Post updatePost(@PathVariable("id") Integer id, @RequestBody @Valid Post post, BindingResult result) {
//		if (result.hasErrors()) {
//			throw new IllegalArgumentException("Invalod Post data");
//		}
//		postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
//		return postRepository.save(post);
//	}
//
//	
//
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/{id}/comments")
//	public void createPostComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
//
//		Post post = postRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
//		comment.setPost(post);
//		post.getComments().add(comment);
//		postRepository.save(post);
//	}
//
//	
//
//	@ExceptionHandler(PostDeletionException.class)
//	public ResponseEntity<?> servletRequestBindingException(PostDeletionException e) {
//		ErrorDetails errorDetails = new ErrorDetails();
//		errorDetails.setErrorMessage(e.getMessage());
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//		e.printStackTrace(pw);
//		errorDetails.setDevErrorMessage(sw.toString());
//		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
