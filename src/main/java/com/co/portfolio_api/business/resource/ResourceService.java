package com.co.portfolio_api.business.resource;


import com.amazonaws.services.s3.AmazonS3Client;
import com.co.portfolio_api.db.entity.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResourceService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3Client amazonS3Client;
    private final ResourceRepository repository;

    public ResourceDto.ResourceRslt postImageUrl(ResourceDto.ResourceCond cond) {
        ResourceDto.ResourceRslt res = new ResourceDto.ResourceRslt();
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusMinutes(30);


        try {
            Resource resources = repository.findByName(cond.getName());

            if (resources == null) {
                throw new RuntimeException("not found image!");
            } else {
                URL generatePresignedUrl = amazonS3Client.generatePresignedUrl(bucket, String.format("%s%s.%s", resources.getPath(), resources.getName(), resources.getExtension()), java.sql.Timestamp.valueOf(dateTime));
                res.setPreSingedUrl(generatePresignedUrl.toString());
                res.setName(cond.name);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ResourceDto.ResourceRslt> postImagesUrl(List<ResourceDto.ResourceCond> conds) {
        List<ResourceDto.ResourceRslt> resourceRslts = new ArrayList<>();

        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusMinutes(30);

        for (ResourceDto.ResourceCond cond : conds) {
            Resource resources = repository.findByName(cond.getName());

            ResourceDto.ResourceRslt res = new ResourceDto.ResourceRslt();
            URL generatePresignedUrl = amazonS3Client.generatePresignedUrl(bucket, String.format("%s%s.%s", resources.getPath(), resources.getName(), resources.getExtension()), java.sql.Timestamp.valueOf(dateTime));
            res.setPreSingedUrl(generatePresignedUrl.toString());
            res.setName(cond.name);
            resourceRslts.add(res);

        }
        return resourceRslts;
    }
}
