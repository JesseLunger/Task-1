package person;


import location.Department;
import location.Hospital;
import schedule.Appointment;

public class Patient extends Person {
    /*Description: Child of Person Class. This class is used for most lookups to determine doctor and nurse
     *
     *Args not in Person: doctor: patients pcp and whom they schedule appointments with if noncritical
     *                    department: department of their doctor, which we assume pt will be staying
     * */
    private Integer id;
    private String symptoms;
    private Doctor doctor;
    private Department department;
    private Integer floorNumber;

    private Appointment appointment;
    private boolean critical = false;

    public Patient(String fn, String ln, Integer age,
                   Character s, Doctor doctor, Integer id) {
        super(fn, ln, age, s);
        this.doctor = doctor;
        this.department = doctor.getDepartment();
        this.id = id;
    }

    @Override
    public String getName() {
        return "(patient: " + this.id + ")" + super.getName();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String getSymptoms() {
        return this.symptoms;
    }

    //GetterSetter functions
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public boolean getCritical() {
        return this.critical;
    }

    public void setCritical(boolean critical) {
        /*Decription: if pt is critical they are able to get an appointment with doctor their department
         * that is not their pcp
         *
         * Args: critical: pt state, set to true of pt needs emergency treatment
         * */
        this.critical = critical;
    }

    public Integer getId() {
        return this.id;
    }

    /*getter/setter functions*/
    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public Hospital getHospital() {
        return this.department.getHospital();
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getFloorNumber() {
        return this.floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    ;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment app) {
        this.appointment = app;
    }
}