package agha.rimaa.rimaacarme.pkgData;

import java.util.Date;

/**
 * Created by user on 25/04/2018.
 */

public class Report
{
    private String keyProfile;
    private String keyId;
    private String type;
    private double lat,lng;
    private String status;
    private String email;
    private String phone;
    private Date time;

    public Report()
    {

    }

    public String getKeyProfile() {
        return keyProfile;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setKeyProfile(String keyProfile) {
        this.keyProfile = keyProfile;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
