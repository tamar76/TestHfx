package com.test.test.model;
import com.test.test.model.enums.ContactMethodType;
    import java.util.Set;
    import jakarta.persistence.*;

    
    @Entity
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String contactValue; 
        private ContactMethodType contactMethodType;
             public Customer(long id, String contactValue,ContactMethodType contactMethodType) {
this.id=id;
this.contactValue=contactValue;
this.contactMethodType=contactMethodType;

        }
            public void setId(Long id){
            this.id=id;
           }
           public Long getId(){
           return id;
           }
           public void setContactValue(String contactValue){
            this.contactValue=contactValue;
           }
           public String getContactValue(){
           return contactValue;
           }
           public void setContactMethodType(ContactMethodType contactMethodType){
            this.contactMethodType=contactMethodType;
           }
           public ContactMethodType getContactMethodType(){
           return contactMethodType;
           }
    }


