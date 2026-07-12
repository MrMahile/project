-- US006: Add Title and Bill Number columns to Customer table

ALTER TABLE Customer ADD Title VARCHAR(10);
ALTER TABLE Customer ADD BillNumber BIGINT;
