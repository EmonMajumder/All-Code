use chinook;
INSERT INTO Track (Name, UnitPrice, MediaTypeId, Milliseconds)
VALUES ('Craig','4.56','2','152');

select * from Track
left join PlaylistTrack on Track.TrackId=PlaylistTrack.TrackId
where PlaylistTrack.PlaylistId is null;

select Name, count(InvoiceLine.invoiceid) as Purchased from Track
left join InvoiceLine on Track.TrackId=InvoiceLine.InvoiceLineId
group by Name order by Purchased asc;

select Name from Track
left join InvoiceLine on Track.TrackId=InvoiceLine.InvoiceLineId
where InvoiceId is null order by Name asc;