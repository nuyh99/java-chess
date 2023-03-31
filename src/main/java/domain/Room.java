package domain;

import java.util.Objects;

public final class Room {
    private static final int MIN_ROOM_NAME = 1;
    private static final int MAX_ROOM_NAME = 20;
    private static final String INVALID_ROOM_NAME_LENGTH = "방 이름은 1 ~ 20 글자입니다.";

    private Long id;
    private final String name;

    public Room(final String name) {
        this(null, name);
    }

    public Room(final Long id, final String name) {
        validate(name);
        this.id = id;
        this.name = name;
    }

    private void validate(final String name) {
        if (name.length() < MIN_ROOM_NAME || MAX_ROOM_NAME < name.length()) {
            throw new IllegalArgumentException(INVALID_ROOM_NAME_LENGTH);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        final Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
