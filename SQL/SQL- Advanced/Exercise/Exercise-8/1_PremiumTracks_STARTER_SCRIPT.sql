USE [Chinook]
GO
-- Create a new table to hold Premium Tracks
-- Based on existing Track table, with these changes:
--		- GenreID, AlbumID and MediaTypeID fields removed
--		- New field added for Rating
DROP TABLE PremiumTrack;
GO
CREATE TABLE [dbo].[PremiumTrack](
	[TrackId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Composer] [nvarchar](220) NULL,
	[Milliseconds] [int] NOT NULL,
	[Bytes] [int] NULL,
	[UnitPrice] [numeric](10, 2) NOT NULL,
	[Rating] int NOT NULL CHECK (Rating IN (1,2,3,4,5)),
 CONSTRAINT [PK_PremiumTrack] PRIMARY KEY CLUSTERED 
(
	[TrackId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO