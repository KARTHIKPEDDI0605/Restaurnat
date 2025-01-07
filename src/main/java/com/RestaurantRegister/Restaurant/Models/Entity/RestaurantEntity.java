package com.RestaurantRegister.Restaurant.Models.Entity;

import com.RestaurantRegister.Restaurant.Utils.Address;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "restaurant_id", columnDefinition = "CHAR(36)")
    private String restaurantId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_phone_number")
    private String ownerPhoneNumber;

    @Column(name = "owner_email")
    private String ownerEmail;

    @Column(name = "owner_address")
    private String ownerAddress;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "restaurant_status")
    private String status;

    // Setter methods
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // Getter methods
    public String getRestaurantId() {
        return restaurantId;
    }

    public  String getStatus() {
        return status;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    // Builder pattern for creating RestaurantEntity
    public static class Builder {

        private String restaurantId;
        private String userName;
        private String password;
        private String restaurantName;
        private Address address;
        private String phoneNumber;
        private String email;
        private String ownerName;
        private String ownerPhoneNumber;
        private String ownerEmail;
        private String ownerAddress;
        private String startTime;
        private String endTime;
        private LocalDateTime createdAt;
        private String createdBy;
        private LocalDateTime lastModifiedAt;
        private String lastModifiedBy;
        private String status;

        public Builder restaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder restaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder ownerPhoneNumber(String ownerPhoneNumber) {
            this.ownerPhoneNumber = ownerPhoneNumber;
            return this;
        }

        public Builder ownerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public Builder ownerAddress(String ownerAddress) {
            this.ownerAddress = ownerAddress;
            return this;
        }

        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastModifiedAt(LocalDateTime lastModifiedAt) {
            this.lastModifiedAt = lastModifiedAt;
            return this;
        }

        public Builder lastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        // Build method that returns a fully constructed RestaurantEntity object
        public RestaurantEntity build() {
            RestaurantEntity restaurantEntity = new RestaurantEntity();
            restaurantEntity.restaurantId = this.restaurantId;
            restaurantEntity.userName = this.userName;
            restaurantEntity.password = this.password;
            restaurantEntity.restaurantName = this.restaurantName;
            restaurantEntity.phoneNumber = this.phoneNumber;
            restaurantEntity.email = this.email;
            restaurantEntity.ownerName = this.ownerName;
            restaurantEntity.ownerPhoneNumber = this.ownerPhoneNumber;
            restaurantEntity.ownerEmail = this.ownerEmail;
            restaurantEntity.ownerAddress = this.ownerAddress;
            restaurantEntity.startTime = this.startTime;
            restaurantEntity.endTime = this.endTime;
            restaurantEntity.createdAt = this.createdAt;
            restaurantEntity.createdBy = this.createdBy;
            restaurantEntity.lastModifiedAt = this.lastModifiedAt;
            restaurantEntity.lastModifiedBy = this.lastModifiedBy;
            restaurantEntity.status = this.status;
            return restaurantEntity;
        }
    }

    // Optional: Static builder method for easier usage
    public static Builder builder() {
        return new Builder();
    }
}
