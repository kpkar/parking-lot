package com.interview.parkinglot;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.parkinglot.dto.VehicleRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParkingLotManagerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	int randomPort;

	@Test
	public void testStoreVehicle() throws URISyntaxException, ParseException {
		String baseUrl = "http://localhost:" + randomPort + "/api/v1/parking-lot/vehicle/";
		URI uri = new URI(baseUrl);

		VehicleRequestDto vehicleRequestDto = new VehicleRequestDto();
		vehicleRequestDto.setVechicleType("Car");
		vehicleRequestDto.setVechicleNumber(2231);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date iDate = simpleDateFormat.parse("2020-05-21 15:50:00");
		vehicleRequestDto.setIncomingTime(iDate);
		Date oDate = simpleDateFormat.parse("2020-05-21 17:50:00");
		vehicleRequestDto.setIncomingTime(oDate);

		HttpEntity<VehicleRequestDto> request = new HttpEntity<>(vehicleRequestDto);
		ResponseEntity<String> result = this.testRestTemplate.postForEntity(uri, request, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
