package Person;

import java.util.*;
import Location.Department;
import Scheduling.Appointment;

public class Doctor extends Employee{

    ArrayList<Appointment> appointments = new ArrayList<>();
    Stack<Integer> getAvailableAppID = new Stack<>();


    public Doctor(String fn, String ln, Integer age, Character s, Department dep) {
        /* Description: class constructor for Doctor, does not require any additional parameters
        * beyond the parent class
        *
        * Args: see package Person.Employee
        * */
        super(fn, ln, age, s, dep);
    }


    /*Str Override*/
    @Override
    public String getName() {
        /*Description: overriding from the parent Person.getName() to add in tittle
        *
        * Args: None
        * */
        return "(doctor)" + super.getName();
    }

    /*hash override*/
    @Override
    public int hashCode() {
        /*Description: hashfunction that uses class variable to form hash
        *
        * Args: none
        * */
        int result = 17;
        result = 31 * result + this.getName().hashCode();
        result = 31 * result + this.getId();
        return result;
    }

    /*equals override*/
    @Override
    public boolean equals(Object obj){
        /*Description: override equals that checks for null, same class and equal hash function
        *
        * Args: obj: any object
        * */
        if (obj == null || this.getClass() != obj.getClass() || this.hashCode() != obj.hashCode()){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        /*Description: Overrides original toString and replaces it with the getName method
        *
        * Args: none
        * */
        return this.getName();
    }

    public void addAppointment(Appointment appointment){
        /*Description: Add appointment using id's as the index into the appointments array.
         *Also save potential ids not in use. Runtime O(1) Space O(2n)
         *
         * Args: appointment: (see in Scheduling Package)
         * */
        if (this.getAvailableAppID.isEmpty()){
            appointment.setId(appointments.size());
            this.appointments.add(appointment);
        }else {
            Integer next = this.getAvailableAppID.pop();
            appointment.setId(next);
            this.appointments.set(next, appointment);
        }

    }

    public void removeAppointment(Appointment appointment){
        /*Description: Remove appointment while also saving index/id.
         *Runtime O(1) Space O(2n)
         *
         * Args: appointment: (see in Scheduling Package)
         * */
        this.getAvailableAppID.push(appointment.getId());
        this.appointments.set(appointment.getId(), null);
    }

    /*getters*/
    public ArrayList<Appointment> getAppointments(){
        return this.appointments;
    }


}
