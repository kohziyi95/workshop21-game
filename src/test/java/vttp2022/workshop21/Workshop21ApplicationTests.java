package vttp2022.workshop21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp2022.workshop21.model.Comment;
import vttp2022.workshop21.model.Game;
import vttp2022.workshop21.repositories.GameRepository;

@SpringBootTest
class Workshop21ApplicationTests {

	@Autowired
	private GameRepository gameRepo;

	@Test
	void shouldReturnAGame() {
		Optional<Game> opt  = gameRepo.getGameByGid(10);
		assertTrue(opt.isPresent(), "gid = 10");
	}

	@Test
	void shouldReturnEmpty() {
		Optional<Game> opt  = gameRepo.getGameByGid(10000);
		assertFalse(opt.isPresent(), "gid = 10000");
	}

	@Test
	void shouldReturnAComment() {
		List<Comment> comment  = gameRepo.getCommentsByGid(10);
		assertEquals(comment.size(), 42, "number of comments for gid = 10 is 42");
	}

	@Test
	void shouldReturnEmptyList() {
		List<Comment> comment  = gameRepo.getCommentsByGid(10000, 10, 5);
		assertTrue(comment.isEmpty(), "List of comments should be empty for gid = 10000");
	}


}
