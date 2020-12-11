package com.space.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ship
{
    private Long id;
    private String name; /*Название корабля (до 50 знаков включительно)*/
    private String planet; /*Планета пребывания (до 50 знаков включительно)*/
    private ShipType shipType;
    private Date prodDate; /*Диапазон значений года 2800..3019 включительно*/
    private Boolean isUsed = false;
    private Double speed; /*Диапазон значений 0,01..0,99 включительно*/
    private Integer crewSize; /*Диапазон значений 1..9999 включительно.*/
    private Double rating;

    public void setRating() throws ParseException
    {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy");
        String currentDateS = "3019";
        Date currentDate = sd.parse(currentDateS);
        int currentYear = Integer.parseInt(sd.format(currentDate));
        int prodYear = Integer.parseInt(sd.format(prodDate));
        double k = isUsed ? 0.5 : 1;
        rating = Math.round((80 * speed * k) / (currentYear - prodYear + 1) * 100.0) / 100.0;
    }
}
