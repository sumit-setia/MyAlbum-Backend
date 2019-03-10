/**
 * 
 */
package com.sumit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.Dao.PhotoDao;
import com.sumit.models.Photo;
import com.sumit.models.User;

/**
 * @author Sumit
 *
 */
@Service
public class PhotoServiceImpl implements PhotoService {

	
	@Autowired 
	PhotoDao photoDao;
	/* (non-Javadoc)
	 * @see com.sumit.service.PhotoService#save(com.sumit.models.Photo)
	 */
	@Override
	public Photo save(Photo photo) {
		// TODO Auto-generated method stub
		return photoDao.save(photo);
	}

	/* (non-Javadoc)
	 * @see com.sumit.service.PhotoService#findAll()
	 */
	@Override
	public List<Photo> findAll() {
		// TODO Auto-generated method stub
		return photoDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sumit.service.PhotoService#findByUser()
	 */
	@Override
	public List<Photo> findByUser(User user) {
		// TODO Auto-generated method stub
		return photoDao.findByUser(user);
	}

	/* (non-Javadoc)
	 * @see com.sumit.service.PhotoService#findByPhotoId(java.lang.Long)
	 */
	@Override
	public Photo findByPhotoId(Long photoId) {
		// TODO Auto-generated method stub
		return photoDao.findByPhotoId(photoId);
	}

}
