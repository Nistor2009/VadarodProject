package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.*;
import com.example.VadarodProject.entity.Address;
import com.example.VadarodProject.mapper.CureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {
    private final CureService cureService;
    private final ReviewService reviewService;
    private final CureMapper cureMapper;
    private final RecipeService recipeService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final DeliveryManService deliveryManService;
    private final OrderService orderService;
    private final PharmacyService pharmacyService;
    private final PriceService priceService;

    private void fillCure(){
        CureDto cure = new CureDto();
        cure.setId(null);
        cure.setName("Валидол");
        cure.setNeedRecipe(false);
        cureService.addCure(cure);
        CureDto cure2 = new CureDto();
        cure2.setId(null);
        cure2.setName("Аспирин");
        cure2.setNeedRecipe(false);
        cureService.addCure(cure2);
        System.out.println("Добавили Cure");
    }

    private void fillRecipe() {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(null);
        recipeDto.setDescription("2 раза в день");
        recipeDto.setCure(cureMapper.toEntity(cureService.findById(1L)));
        recipeService.addRecipe(recipeDto);
        RecipeDto recipeDto2 = new RecipeDto();
        recipeDto2.setId(null);
        recipeDto2.setDescription("3 раза в день");
        recipeDto2.setCure(cureMapper.toEntity(cureService.findById(2L)));
        recipeService.addRecipe(recipeDto2);
        System.out.println("Добавили Recipe");
    }

    private void fillReview() {
        ReviewDto review = new ReviewDto();
        review.setId(null);
        review.setClientName("Вася Пупкин");
        review.setDescription("Что-то не понравилось");
        review.setMark(3);
        reviewService.addReview(review);
        ReviewDto review2 = new ReviewDto();
        review2.setId(null);
        review2.setClientName("Дуня Мартинкевич");
        review2.setDescription("Да всё ОК");
        review2.setMark(5);
        reviewService.addReview(review2);
        System.out.println("Добавили Review");
    }

    private void fillClient() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(null);
        clientDto.setAge(39);
        clientDto.setName("Дуня");
        clientDto.setSurname("Мартинкевич");
        clientDto.setPhone("+375396652244");
        clientService.addClient(clientDto);
        ClientDto clientDto2 = new ClientDto();
        clientDto2.setId(null);
        clientDto2.setAge(54);
        clientDto2.setName("Вася");
        clientDto2.setSurname("Пупкин");
        clientDto2.setPhone("+37531235489");
        clientService.addClient(clientDto2);
        System.out.println("Добавили Client");
    }

    private void fillDeliveryMan() {
        DeliveryManDto deliveryManDto = new DeliveryManDto();
        deliveryManDto.setId(null);
        deliveryManDto.setName("Америго");
        deliveryManDto.setSurname("Веспуччи");
        deliveryManDto.setPhone("+375449986652");
        deliveryManService.addDeliveryMan(deliveryManDto);
        DeliveryManDto deliveryManDto2 = new DeliveryManDto();
        deliveryManDto2.setId(null);
        deliveryManDto2.setName("Америго2");
        deliveryManDto2.setSurname("Веспуччи2");
        deliveryManDto2.setPhone("+375449986653");
        deliveryManService.addDeliveryMan(deliveryManDto2);
        System.out.println("Добавили DeliveryMan");
    }

    private void fillDelivery() {
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setId(null);
        deliveryDto.setName("P-доставка");
        deliveryService.addDelivery(deliveryDto);
        DeliveryDto deliveryDto2 = new DeliveryDto();
        deliveryDto2.setId(null);
        deliveryDto2.setName("P-доставка");
        deliveryService.addDelivery(deliveryDto2);
        System.out.println("Добавили Delivery");
    }

    private void fillPrice() {
        PriceDto priceDto = new PriceDto();
        priceDto.setId(null);
        priceDto.setPrice(12.0);
        priceService.addPrice(priceDto);
        PriceDto priceDto2 = new PriceDto();
        priceDto2.setId(null);
        priceDto2.setPrice(13.0);
        priceService.addPrice(priceDto2);
        System.out.println("Добавили Price");
    }

    private void fillOrder() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(null);
        orderDto.setState(1);
        orderService.addOrder(orderDto);
        OrderDto orderDto2 = new OrderDto();
        orderDto2.setId(null);
        orderDto2.setState(1);
        orderService.addOrder(orderDto);
        System.out.println("Добавили Order");
    }

    private void fillPharmacy() {
        PharmacyDto pharmacyDto = new PharmacyDto();
        pharmacyDto.setId(null);
        pharmacyDto.setName("Новая аптека");
        pharmacyDto.setAddress(new Address());
        pharmacyService.addPharmacy(pharmacyDto);
        PharmacyDto pharmacyDto2 = new PharmacyDto();
        pharmacyDto2.setId(null);
        pharmacyDto2.setName("Старая аптека");
        pharmacyDto2.setAddress(new Address());
        pharmacyService.addPharmacy(pharmacyDto2);
        System.out.println("Добавили Pharmacy");
    }

    public void fillTable(){
        fillCure();
        fillReview();
        fillRecipe();
        fillClient();
        fillDeliveryMan();
        fillDelivery();
        fillPrice();
        fillOrder();
        fillPharmacy();
    }

}
