package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Notification;
import uef.edu.vn.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> findLatest(
            int limit) {

        try {

            return notificationRepository.findLatest(
                    limit);

        } catch (DataAccessException ex) {

            return java.util.Collections.emptyList();
        }
    }

    public int countUnread() {

        try {

            return notificationRepository.countUnread();

        } catch (DataAccessException ex) {

            return 0;
        }
    }

    public int create(
            Integer orderId,
            String message) {

        Notification notification
                = new Notification();

        notification.setOrderId(
                orderId);

        notification.setMessage(
                message);

        notification.setRead(false);

        try {

            return notificationRepository.save(
                    notification);

        } catch (DataAccessException ex) {

            return 0;
        }
    }
}
