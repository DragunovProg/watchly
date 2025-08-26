package ua.dragunov.watchlyapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dragunov.watchlyapi.dto.WatchlistItemResponse;
import ua.dragunov.watchlyapi.dto.WatchlistItemUpdateRequest;
import ua.dragunov.watchlyapi.service.WatchlistItemService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("api/v1/watchlist")
public class WatchlistItemController {
    private final WatchlistItemService watchlistItemService;

    public WatchlistItemController(WatchlistItemService watchlistItemService) {
        this.watchlistItemService = watchlistItemService;
    }

    @GetMapping
    public ResponseEntity<Page<WatchlistItemResponse>> findAll(@RequestParam int page, @RequestParam int size) {

        return ResponseEntity.ok(watchlistItemService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable int id, @RequestBody WatchlistItemUpdateRequest request) {
        watchlistItemService.updateById(id, request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "Timestamp", LocalDateTime.now().toString(),
                        "message", "success")
                );

    }
}
