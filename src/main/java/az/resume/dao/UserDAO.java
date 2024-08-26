package az.resume.dao;

import az.resume.dao.model.*;

public abstract class UserDAO implements Callable, CallableById, Updatable, Deletable {
    protected abstract void add(Object object);
}
