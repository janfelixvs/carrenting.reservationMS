package com.carrenting.reservationMS.feign;


import com.carrenting.reservationMS.dto.MaintenanceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "maintenance-service", url = "http://maintenance:8084")
public interface MaintenanceClient {
    @GetMapping("/api/maintenance")
    List<MaintenanceDto>getAllMaintenances(); //get Maintenance
}
