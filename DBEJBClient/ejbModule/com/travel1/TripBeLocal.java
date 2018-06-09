package com.travel1;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import tr.model.City;
import tr.model.Pic;
import tr.model.Sightseeing;
import tr.model.Traveler;
import tr.model.Trip;
import tr.model.TripSightseeing;


@Local
public interface TripBeLocal {

	int addSightTrip(Sightseeing sightseeing);

	int createSight(String name, City city);

	int addCity(String cityName);

	int createTraveler(String name, Date birthDate);

	List<City> getAllCities();

	int addSight(String name, City city);

	int addTraveller(String name, Date BirthD);

	List<Traveler> getTravellers();

	String removeCity(String ist);

	List<Sightseeing> sightsbycity(String cityidstr);

	int addSighti(String name, String ist);

	int createTrip(String cityi, Date date, String traveleri, int numdays, int moneyspent, String hotel, String Sightseeingi,
			int transit);

	List<Trip> Tripl();

	String getTripCityName(String idt);

	City getCitybyTrip(String idt);

	List<Sightseeing> SightsforTrip(String tri);

	List<Sightseeing> newTripCitySights(String ci, String ti);

	List<TripSightseeing> SightseeingforTrip(String tri);

	String removeSightFromTrip(String si, String ti);

	void addsighttotrip(String sigind, String tripind);

	int setpicsForSighttrip(String addr, String idtrsig);

	List<Pic> picsForSightTrip(String idSight);

	Pic picbyid(String ids);

	void deletPic(String idpic);

	Trip getTripbyId(String idtrip);

	int updateTrip(String tripid, Date date, String numdays, String moneyspent, String hotel, String transit);

}
