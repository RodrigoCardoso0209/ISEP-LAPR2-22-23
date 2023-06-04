package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Commission;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Annoucements request repository.
 */
public class AnnouncementRepository {

    private final List<Announcement> announcements = new ArrayList<>();

    /**
     * Gets announcement by id.
     *
     * @param announcementId the announcement id
     * @return the announcement by id
     */
    public Announcement getAnnouncementById(int announcementId) {
        Announcement announcementReturn = null;
        for (Announcement announcement: announcements) {
            if (announcement.getAnnouncementId() == announcementId) {
                announcementReturn = announcement;
            }
        }
        return announcementReturn;
    }

    /**
     * Create announcement optional.
     *
     * @param request    the request
     * @param commission the commission
     * @return the optional
     */
    public Optional<Announcement> createAnnouncement(Request request, Commission commission){
        Optional<Announcement> optionalValue = Optional.empty();
        Announcement announcement = new Announcement(request, commission);

        if(addAnnouncement(announcement)){
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }

    /**
     * Create announcement with input date optional.
     *
     * @param request    the request
     * @param commission the commission
     * @param date       the date
     * @return the optional
     */
    public Optional<Announcement> createAnnouncementWithInputDate(Request request, Commission commission, Date date){
        Optional<Announcement> optionalValue = Optional.empty();

        Announcement announcement = new Announcement(request, commission);

        if(addAnnouncement(announcement)){
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }

    /**
     * Add announcement boolean.
     *
     * @param announcement the announcement
     * @return the boolean
     */
    public boolean addAnnouncement(Announcement announcement){
        boolean operationSuccess = false;
        if(validateAnnouncement(announcement)){
            operationSuccess = announcements.add(announcement);
        }
        return operationSuccess;
    }

    private boolean validateAnnouncement(Announcement announcement){ return !announcements.contains(announcement);}

    /**
     * Gets announcements.
     *
     * @return the announcements
     */
    public List<Announcement> getAnnouncements() {
        return announcements;
    }
}
