package com.victormartin.projectcawd.domain.interactors.base;

import com.victormartin.projectcawd.domain.interactors.GetUserNameUseCase;

/**
 * This is the main interface of an interactor. Each interactor serves a specific use case.
 */
public interface UseCase {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread.
     */
    void execute(final GetUserNameUseCase.Callback callback);
}
