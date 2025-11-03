package mission1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

class QuoteRepositoryTest {

    @DisplayName("명언 등록 테스트")
    @Test
    void 명언_등록_테스트() {
        QuoteRepository repository = new QuoteRepository();

        Quote quote = repository.save("현재를 사랑하라.", "작자미상");

        assertThat(quote.getId()).isEqualTo(1);
        assertThat(quote.getContent()).isEqualTo("현재를 사랑하라.");
        assertThat(quote.getAuthor()).isEqualTo("작자미상");
    }

    @DisplayName("명언 목록 조회 테스트")
    @Test
    void 명언_목록_조회_테스트() {
        QuoteRepository repository = new QuoteRepository();
        repository.save("현재를 사랑하라.", "작자미상");
        repository.save("과거에 집착하지 마라.", "작자미상");

        List<Quote> quotes = repository.findAll();

        assertThat(quotes).hasSize(2);
        assertThat(quotes.get(0).getContent()).isEqualTo("현재를 사랑하라.");
        assertThat(quotes.get(1).getContent()).isEqualTo("과거에 집착하지 마라.");
    }

    @DisplayName("명언 삭제 테스트")
    @Test
    void 명언_삭제_테스트() {
        QuoteRepository repository = new QuoteRepository();
        repository.save("현재를 사랑하라.", "작자미상");

        boolean deleted = repository.deleteById(1);
        assertThat(deleted).isTrue();

        boolean notDeleted = repository.deleteById(999);
        assertThat(notDeleted).isFalse();
    }

    @DisplayName("ID로 명언 조회 테스트 (핸들러 기준)")
    @Test
    void 명언_조회_테스트() {
        QuoteRepository repository = new QuoteRepository();
        repository.save("현재를 사랑하라.", "작자미상");

        Quote quote = repository.findById(1);
        assertThat(quote).isNotNull();
        assertThat(quote.getContent()).isEqualTo("현재를 사랑하라.");

        Quote missing = repository.findById(999);
        assertThat(missing).isNull();
    }

    @DisplayName("명언 수정 테스트")
    @Test
    void 명언_수정_테스트() {
        QuoteRepository repository = new QuoteRepository();
        repository.save("현재를 사랑하라.", "작자미상");

        repository.update(1, "현재와 자신을 사랑하라.", "홍길동");

        Quote updated = repository.findById(1);
        assertThat(updated).isNotNull();
        assertThat(updated.getContent()).isEqualTo("현재와 자신을 사랑하라.");
        assertThat(updated.getAuthor()).isEqualTo("홍길동");

        repository.update(999, "없는 명언", "익명");
        Quote missing = repository.findById(999);
        assertThat(missing).isNull();
    }
}
