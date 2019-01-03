package com.example.codeclan.course_service.repositories.BookingRepository;

import com.example.codeclan.course_service.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
    List<Booking> getAllBookingsForDate(String date);

    interface BookingRepositoryCustom {
        List<Booking> getAllBookingsForDate(String date);
    }

    class BookingRepositoryImpl implements BookingRepositoryCustom {

        @Autowired
        EntityManager entityManager;

        @Transactional
        public List<Booking> getAllBookingsForDate(String date){
            List<Booking> result = null;
            Session session = entityManager.unwrap(Session.class);
            try {
                Criteria cr = session.createCriteria(Booking.class);
                cr.add(Restrictions.eq("date", date));
                result = cr.list();
            } catch (HibernateException ex){
                ex.printStackTrace();
            } finally {
                session.close();
            }

            return result;

        }
    }
}
