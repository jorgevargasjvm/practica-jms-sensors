package com.vargas.PracticaJMSSensors;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Message {

	private LocalDateTime created_at;
    private Integer idDevice;
    private float temperature;
    private float humidity;
    
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public Integer getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(Integer idDevice) {
		this.idDevice = idDevice;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
    
	public String getJson(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode mensaje = mapper.createObjectNode();
        mensaje.put("created_at", created_at.toString());
        mensaje.put("idDevice", idDevice);
        mensaje.put("temperature", temperature);
        mensaje.put("humidity", humidity);

        String json = "";
        try{
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mensaje);
        } catch (Exception e){
            e.printStackTrace();
        }

        return json;
    }
}
