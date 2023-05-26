package com.berkaygulen.akbankbootcamphw2.mapper;

import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentDTO;
import com.berkaygulen.akbankbootcamphw2.dto.commentDTO.CommentSaveRequestDTO;
import com.berkaygulen.akbankbootcamphw2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequestDTO commentSaveRequestDTO);

    CommentDTO convertToCommentDTO(Comment comment);

    List<CommentDTO> convertToCommentDTOList(List<Comment> commentList);
}
