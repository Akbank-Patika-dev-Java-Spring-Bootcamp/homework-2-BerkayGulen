package com.berkaygulen.akbankbootcamphw2.controller;

import com.berkaygulen.akbankbootcamphw2.controller.contract.CommentControllerContract;
import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentDTO;
import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentControllerContract commentControllerContract;


    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> comment(@RequestBody CommentSaveRequestDTO commentSaveRequestDTO) {
        CommentDTO commentDTO = commentControllerContract.writeComment(commentSaveRequestDTO);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @GetMapping("/getCustomerComments/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> getCustomerComments(@PathVariable Long id){
        List<CommentDTO> customerComments = commentControllerContract.getCustomerComments(id);
        return ResponseEntity.ok(RestResponse.of(customerComments));

    }
    @GetMapping("/getProductComments/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> getProductComments(@PathVariable Long id){
        List<CommentDTO> productComments = commentControllerContract.getProductComments(id);
        return ResponseEntity.ok(RestResponse.of(productComments));

    }

    @DeleteMapping("/{id}")
    ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        commentControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }


}
