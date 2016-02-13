package com.unt.ImageProcessingService.Processing;

import java.util.List;

import org.apache.log4j.Logger;

import com.unt.ImageProcessingService.dao.CameraDAO;
import com.unt.ImageProcessingService.entities.Camera;

public class ApplicationController {

	static final Logger LOGGER = Logger.getLogger(ApplicationController.class);

	public static void start() throws Exception {

		List<Camera> cameras = null;
		ImageProcessorManager imageProcessorManager = new ImageProcessorManager();
		cameras = CameraDAO.getCameraList();

		while (cameras.isEmpty()) {
			Thread.sleep(5000);
			cameras = CameraDAO.getCameraList();
		}

		for (Camera camera : cameras) {
			LOGGER.info("This camera is going to be processed: " + camera);
			imageProcessorManager.startCameraProcessing(camera);
		}
	}
}