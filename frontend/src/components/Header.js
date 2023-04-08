import './Header.css';

function Header() {
  return (
    <header className="header-design">
      <div className="left-buttons">
        <a href="/">Hikmet Cakir</a>
      </div>
      <div className="right-buttons">
        <a href="/article/JAVA">Java</a>
        <a href="/article/SPRING">Spring</a>
        <a href="/article/SQL">SQL</a>
        <a href="/article/ALGORITHM">Algorithm</a>
      </div>
    </header>
  );
}

export default Header;
