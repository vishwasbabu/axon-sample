package lab.mifos.client.query.api.service;


import lab.mifos.client.query.api.domain.Client;

import java.util.List;

public interface ClientService {

    String createClient(Client client);

    void approveClient(String clientId, Boolean approved, String comment);

    List<Client> fetchAll();
}
