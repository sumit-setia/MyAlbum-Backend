/**
 * 
 */
package com.sumit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.models.Photo;
import com.sumit.service.PhotoService;

/**
 * @author Sumit
 *
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {
	@Autowired PhotoService photoService;
	
	@RequestMapping("/allPhotos")
	public List<Photo> getAllPhotos()
	{
		return photoService.findAll();
	}

}
