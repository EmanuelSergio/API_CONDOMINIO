package com.condominio.app.infra.contract.executor;

import com.condominio.app.core.model.Contract;
import com.condominio.app.core.port.ContractRepository;
import com.condominio.app.core.usecase.contract.GetContractByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * GetContractByIdUseCaseAdapter class.
 *
 * @author Wender Couto
 * @since 0.0.0.1-SNAPSHOT
 */

@Service
@RequiredArgsConstructor
public class GetContractByIdUseCaseAdapter implements GetContractByIdUseCase {

    private final ContractRepository contractRepository;

    @Override
    public Optional<Contract> execute(UUID id) {
        return this.contractRepository.findById(id);
    }
}