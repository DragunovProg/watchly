package ua.dragunov.watchlyapi.controller;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dragunov.watchlyapi.dto.MediaItemPreviewResponse;
import ua.dragunov.watchlyapi.dto.MediaItemResponse;
import ua.dragunov.watchlyapi.dto.MediaItemSearchRequest;
import ua.dragunov.watchlyapi.service.MediaItemService;

@RestController
@RequestMapping("api/v1/media")
public class MediaController {
    private final MediaItemService mediaItemService;

    public MediaController(MediaItemService mediaItemService) {
        this.mediaItemService = mediaItemService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<MediaItemResponse> findById(@PathVariable("id") long id) {

        return ResponseEntity.ok(mediaItemService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<MediaItemPreviewResponse>> search(
            @RequestBody MediaItemSearchRequest request
    ) {

        return ResponseEntity.ok(mediaItemService.search(request));
    }
}
