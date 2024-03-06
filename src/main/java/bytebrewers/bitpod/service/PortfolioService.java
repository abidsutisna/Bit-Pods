package bytebrewers.bitpod.service;

import bytebrewers.bitpod.entity.Portfolio;
import bytebrewers.bitpod.entity.User;
import bytebrewers.bitpod.utils.dto.request.portfolio.PortfolioDTO;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PortfolioService {
    Page<Portfolio> getAll(Pageable pageable, PortfolioDTO portfolioDTO);
    Portfolio create(PortfolioDTO portfolioDTO, User cred);
    Portfolio getById(String id);
    Portfolio update(String id, PortfolioDTO portfolioDTO, User cred);
    void delete(String id);
    Portfolio getByUser(User user);
    Portfolio currentUser(String token);
    String generateReport(String id) throws Exception;
}
